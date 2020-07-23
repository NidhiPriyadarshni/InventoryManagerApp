package com.example.inventorymanagerapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.lang.ref.WeakReference;
import java.util.List;

public class ProductRepository {
    private Admindao admindao;
    private LiveData<List<Admintable>> allAdmin;
    private Categorydao categorydao;
    private LiveData<List<Category>> allCategory;
    private Ownerdao ownerdao;
    private LiveData<List<Ownertable>> allOwner;
    private Productdao productdao;
    private LiveData<List<Product>> allProduct;
    private  Salesdao salesdao;
    private LiveData<List<Sales>> allSales;
    private Supplierdao supplierdao;
    private LiveData<List<Supplier>> allSupplier;

    public ProductRepository (Application application){
        ProductDatabase productDatabase=ProductDatabase.getInstance(application);
        admindao=productDatabase.admindao();
        allAdmin=admindao.selectAllAdmin();
        categorydao=productDatabase.categorydao();
        allCategory=categorydao.selectAllCategory();
        ownerdao=productDatabase.ownerdao();
        allOwner=ownerdao.selectAllOwner();
        productdao=productDatabase.productdao();
        allProduct=productdao.selectAllProduct();
        salesdao=productDatabase.salesdao();
        allSales=salesdao.selectAllSales();
        supplierdao=productDatabase.supplierdao();
        allSupplier=supplierdao.selectAllSupplier();


    }

    public void insertAdmin(Admintable admin){
             new insertAdminAsyncTask(admindao).execute(admin);
    }
     //Admintable adi;
    public Admintable selectAdminById(String id){
        return admindao.selectAdminById(id);

        /*Admintable ad=new Admintable(null,null);
        new selectAdminByIdAsyncTask(admindao,ad).execute(id);
        return ad;*/
    }
    public int selectAdminCountById(String id){
        return admindao.selectAdminCountById(id);
    }
    public int checkAdmin(String u, String p){
        return admindao.checkAdmin(u,p);
    }
    public LiveData<List<Admintable>> selectAllAdmin(){
        return allAdmin;
    }
    public void deleteAdmin(Admintable a){
        new deleteAdminAsyncTask(admindao).execute(a);
    }
    public void updateAdmin(Admintable a){
        new updateAdminAsyncTask(admindao).execute(a);
    }


    public void insertCategory(Category c){
         new insertCategoryAsyncTask(categorydao).execute(c);
    }
    public LiveData<List<Category>> selectAllCategory(){
         return allCategory;
    }
    public void deleteCategory(Category c){
         new deleteCategoryAsyncTask(categorydao).execute(c);
    }
    public String selectCategoryByName(String name){
        return categorydao.selectByName(name);
    }


    public void insertOwner(Ownertable owner){
          new insertOwnerAsyncTask(ownerdao).execute(owner);
    }
    public void deleteOwner(Ownertable owner){
          new deleteOwnerAsyncTask(ownerdao).execute(owner);
    }
    public Ownertable selectOwnerById(String id){
          return ownerdao.selectOwnerById(id);
    }
    public int selectOwnerCountById(String id){
        return ownerdao.selectOwnerCountById(id);
    }
    public int checkOwner(String u,String p){
        return ownerdao.checkOwner(u,p);
    }
    public LiveData<List<Ownertable>> selectAllOwner(){
          return allOwner;
    }


    public void insertProduct(Product product){
          new insertProductAsyncTask(productdao).execute(product);
    }
    public void updateproductlist(List<Product> p){
        new updateProductListAsyncTask(productdao).execute(p);
    }
    public Product checkCode(String code){
          return productdao.checkCode(code);
    }
    public void updateProduct(Product product){
          new updateProductAsyncTask(productdao).execute(product);
    }
    public LiveData<List<Product>> selectAllProduct(){
          return allProduct;
    }
    public void deleteProduct(Product product){
          new deleteProductAsyncTask(productdao).execute(product);
    }
    public  Product selectProductById(int id){
        return  productdao.selectProductById(id);
    }


    public void insertSales(Sales sales){
          new insertSalesAsyncTask(salesdao).execute(sales);
    }
    public Sales selectSalesById(int id){
          return salesdao.selectSalesById(id);
    }
    public List<Sales> selectByDate(long datee){
          return salesdao.selectByDate(datee);
    }
    public LiveData<List<Sales>> selectAllSales(){
          return allSales;
    }
    public void updateSales(Sales s){
           new updateSalesAsyncTask(salesdao).execute(s);
    }
    public long inserts(Sales s){return salesdao.insert(s.getDate(),s.getCustomer(),s.getPhone(),s.getAmount());}


    public void insertSupplier(Supplier supplier){
           new insertSupplierAsyncTask(supplierdao).execute(supplier);
    }
    public LiveData<List<Supplier>> selectAllSupplier(){
           return allSupplier;
    }
    public void deleteSupplier(Supplier s){
           new deleteSupplierAsyncTask(supplierdao).execute(s);
    }

    private static class insertAdminAsyncTask extends AsyncTask<Admintable,Void,Void>{
        private Admindao admindao;
        private insertAdminAsyncTask(Admindao admindao){
            this.admindao=admindao;
        }

        @Override
        protected Void doInBackground(Admintable... admintables) {
            admindao.insertAdmin(admintables[0]);
            return null;
        }
    }
    /*private class selectAdminByIdAsyncTask extends AsyncTask<String,Void,Admintable>{

        private Admindao admindao;
        Admintable ad;
        private WeakReference<Admintable> wr;
        public selectAdminByIdAsyncTask(Admindao admindao,Admintable add){
            this.admindao=admindao;
            wr= new WeakReference<Admintable>(add);
        }

        @Override
        protected void onPreExecute() {
            adi=new Admintable(null,null);
        }

        @Override
        protected Admintable doInBackground(String... strings) {
            ad= admindao.selectAdminById(strings[0]);
            return ad;
        }

        @Override
        protected void onPostExecute(Admintable admintable) {
            Admintable adm=wr.get();
            adm=admintable;
        }
    }*/

    private static class deleteAdminAsyncTask extends AsyncTask<Admintable,Void,Void>{
        private Admindao admindao;
        private deleteAdminAsyncTask(Admindao admindao){
            this.admindao=admindao;
        }

        @Override
        protected Void doInBackground(Admintable... admintables) {
            admindao.deleteAdmin(admintables[0]);
            return null;
        }
    }
    private static class updateAdminAsyncTask extends AsyncTask<Admintable,Void,Void>{
        private Admindao admindao;
        private updateAdminAsyncTask(Admindao admindao){
            this.admindao=admindao;
        }

        @Override
        protected Void doInBackground(Admintable... admintables) {
            admindao.updateAdmin(admintables[0]);
            return null;
        }
    }


    private static class insertCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
        private Categorydao categorydao;
        private insertCategoryAsyncTask(Categorydao categorydao){
            this.categorydao=categorydao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categorydao.insertCategory(categories[0]);
            return null;
        }
    }

    private static class deleteCategoryAsyncTask extends AsyncTask<Category,Void,Void>{
        private Categorydao categorydao;
        private deleteCategoryAsyncTask(Categorydao categorydao){
            this.categorydao=categorydao;
        }

        @Override
        protected Void doInBackground(Category... categories) {
            categorydao.deleteCategory(categories[0]);
            return null;
        }
    }


    private static class insertOwnerAsyncTask extends AsyncTask<Ownertable,Void,Void>{
        private Ownerdao ownerdao;
        private insertOwnerAsyncTask(Ownerdao ownerdao){
            this.ownerdao=ownerdao;
        }

        @Override
        protected Void doInBackground(Ownertable... ownertables) {
            ownerdao.insertOwner(ownertables[0]);
            return null;
        }
    }
    private static class deleteOwnerAsyncTask extends AsyncTask<Ownertable,Void,Void>{
        private Ownerdao ownerdao;
        private deleteOwnerAsyncTask(Ownerdao ownerdao){
            this.ownerdao=ownerdao;
        }

        @Override
        protected Void doInBackground(Ownertable... ownertables) {
            ownerdao.deleteOwner(ownertables[0]);
            return null;
        }
    }
   /* private static class selectOwnerByIdAsyncTask extends AsyncTask<String,Void,Ownertable>{
        private Ownerdao ownerdao;
        private selectOwnerByIdAsyncTask(Ownerdao ownerdao){
            this.ownerdao=ownerdao;
        }

        @Override
        protected Ownertable doInBackground(String... strings) {
            return ownerdao.selectOwnerById(strings[0]);
        }
    }*/


    private static class insertProductAsyncTask extends AsyncTask<Product,Void,Void>{
        private Productdao productdao;

        private insertProductAsyncTask(Productdao productdao) {
            this.productdao = productdao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            if(products!=null)productdao.insertProduct(products[0]);
            return null;
        }
    }
   /* private static class checkCodeAsyncTask extends AsyncTask<String,Void,Boolean> {
        private Productdao productdao;

        private checkCodeAsyncTask(Productdao productdao) {
            this.productdao = productdao;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            if(productdao.checkCode(strings[0]).size()>0)return false;
            return true;
        }
    }*/
   private static class updateProductAsyncTask extends AsyncTask<Product,Void,Void>{
        private Productdao productdao;
        private updateProductAsyncTask(Productdao productdao){
            this.productdao=productdao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productdao.updateProduct(products[0]);
            return null;
        }
    }

    private static class updateProductListAsyncTask extends AsyncTask<List<Product>,Void,Void>{
        private Productdao productdao;
        private updateProductListAsyncTask(Productdao productdao){
            this.productdao=productdao;
        }

        @Override
        protected Void doInBackground(List<Product>... lists) {
            productdao.updatelist(lists[0]);
            return null;
        }
    }

    private static class deleteProductAsyncTask extends AsyncTask<Product,Void,Void>{
        private Productdao productdao;
        private deleteProductAsyncTask(Productdao productdao){
            this.productdao=productdao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productdao.deleteProduct(products[0]);
            return null;
        }
    }


    private static class insertSalesAsyncTask extends AsyncTask<Sales,Void,Void>{
        private Salesdao salesdao;
        private insertSalesAsyncTask(Salesdao salesdao){
            this.salesdao=salesdao;
        }

        @Override
        protected Void doInBackground(Sales... sales) {
            salesdao.updateSales(sales[0]);
            return null;
        }
    }
   /* private static class selectSalesByIdAsyncTask extends AsyncTask<Integer,Void,Sales>{
        private Salesdao salesdao;
        private selectSalesByIdAsyncTask(Salesdao salesdao){
            this.salesdao=salesdao;
        }

        @Override
        protected Sales doInBackground(Integer... integers) {
            return salesdao.selectSalesById(integers[0].intValue());
        }


    }*/
  /*  private static class selectByDateAsyncTask extends AsyncTask<Long,Void,List<Sales>>{
        private Salesdao salesdao;
        private selectByDateAsyncTask(Salesdao salesdao){
            this.salesdao=salesdao;
        }

        @Override
        protected List<Sales> doInBackground(Long... longs) {
            return salesdao.selectByDate(longs[0]);
        }
    }*/

    private static class updateSalesAsyncTask extends AsyncTask<Sales,Void,Void>{
        private Salesdao salesdao;
        private updateSalesAsyncTask(Salesdao salesdao){
            this.salesdao=salesdao;
        }

        @Override
        protected Void doInBackground(Sales... sales) {
            salesdao.updateSales(sales[0]);
            return null;
        }
    }



    private static class insertSupplierAsyncTask extends AsyncTask<Supplier,Void,Void>{
        private  Supplierdao supplierdao;
        private insertSupplierAsyncTask(Supplierdao supplierdao){
            this.supplierdao=supplierdao;

        }

        @Override
        protected Void doInBackground(Supplier... suppliers) {
            supplierdao.insertSupplier(suppliers[0]);
            return null;
        }
    }

    private static class deleteSupplierAsyncTask extends AsyncTask<Supplier,Void,Void>{
        private  Supplierdao supplierdao;
        private deleteSupplierAsyncTask(Supplierdao supplierdao){
            this.supplierdao=supplierdao;

        }

        @Override
        protected Void doInBackground(Supplier... suppliers) {
            supplierdao.deleteSupplier(suppliers[0]);
            return null;
        }
    }
}
