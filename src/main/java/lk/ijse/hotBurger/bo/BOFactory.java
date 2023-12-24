package lk.ijse.hotBurger.bo;

import lk.ijse.hotBurger.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        ACCOUNT_INFO,ADD_NEW_ITEM,ADMIN_LOGIN,BURGER_CATEGORY,CART_TABLE,CASHIER_WORK,CREATE_ITEM,CUSTOMER_DETAIL,DASHBOARD,DASHBOARD_PANE,DELIVERY,DINE_IN,FORGET_CHANGE_PASSWORD,FORGET_PASSWORD,GMAIL_ITEM,GRID_PANE_ITEM,INITIALIZE_FORGET_PASSWORD,ITEM_CATEGORY,MANAGE_ITEM,MANAGE_ITEM_CATEGORY,MANAGE_ORDER,REMOVE_INGREDIENTS,SAUCES,SEND_CODE_FOR_EMAIL,UPDATE_ITEM
    }

    public SuperBO BOTypes(BOTypes boTypes){
        switch (boTypes){
            case ACCOUNT_INFO:
                return new AccountInfoBOImpl();
            case ADD_NEW_ITEM:
                return new AddNewItemBOImpl();
            case ADMIN_LOGIN:
                return new AdminLoginBOImpl();
            case BURGER_CATEGORY:
                return new BurgerCategoryBOImpl();
            case CART_TABLE:
                return new CartTableBOImpl();
            case CASHIER_WORK:
                return new CashierWorkBOImpl();
            case CREATE_ITEM:
                return new CreateItemBOImpl();
            case CUSTOMER_DETAIL:
                return new CustomerDetailBOImpl();
            case DASHBOARD:
                return new DashboardBoImpl();
            case DASHBOARD_PANE:
                return new DashboardBoImpl();
            case DELIVERY:
                return new DeliveryBOImpl();
            case DINE_IN:
                return new DineInBOImpl();
            case FORGET_CHANGE_PASSWORD:
                return new ForgetChangePasswordBOImpl();
            case FORGET_PASSWORD:
                return new ForgetPasswordBOImpl();
            case GMAIL_ITEM:
                return new GmailItemBOImpl();
            case INITIALIZE_FORGET_PASSWORD:
                return new InitializeForgetPasswordBOImpl();
            case ITEM_CATEGORY:
                return new ItemCategoryBOImpl();
            case MANAGE_ITEM:
                return new ManageItemBOImpl();
            case MANAGE_ITEM_CATEGORY:
                return new ManageItemCategoryBOImpl();
            case MANAGE_ORDER:
                return new ManageOrderBOImpl();
            case REMOVE_INGREDIENTS:
                return new RemoveIngredientBOImpl();
            case SAUCES:
                return new SaucesBOImpl();
            case SEND_CODE_FOR_EMAIL:
                return new SendCodeForEmailBOImpl();
            case UPDATE_ITEM:
                return new UpdateItemPopUpWindowBOImpl();
            default:
                return null;
        }
    }
}
