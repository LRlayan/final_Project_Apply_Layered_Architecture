package lk.ijse.hotBurger.bo;

import lk.ijse.hotBurger.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        ACCOUNT_INFO,ADD_NEW_ITEM,ADMIN_LOGIN,BURGER_CATEGORY,CART_TABLE,CASHIER_WORK,CUSTOMER_DETAIL,DASHBOARD,DASHBOARD_PANE,DELIVERY,DINE_IN,FORGET_CHANGE_PASSWORD,FORGET_PASSWORD,GMAIL_ITEM,GRID_PANE_ITEM,INITIALIZE_FORGET_PASSWORD,ITEM_CATEGORY,MANAGE_ITEM,MANAGE_ITEM_CATEGORY,MANAGE_ORDER,REMOVE_INGREDIENTS,SAUCES,SEND_CODE_FOR_EMAIL,UPDATE_ITEM,USER
    }

    public SuperBO BOTypes(BOTypes boTypes){
        switch (boTypes){
            case ACCOUNT_INFO:
                return new AccountInfoBOImpl();
            case ADD_NEW_ITEM:
                return new AddNewItemBOImpl();
            case ADMIN_LOGIN:
                return new UserBoImpl();
            case BURGER_CATEGORY:
                return new BurgerCategoryBOImpl();
            case CART_TABLE:
                return new CartTableBOImpl();
            case CASHIER_WORK:
                return new CashierWorkBOImpl();
            case CUSTOMER_DETAIL:
                return new CustomerDetailBOImpl();
            case DASHBOARD:
                return new DashboardBoImpl();
            case DASHBOARD_PANE:
                return new DashboardPaneBoImpl();
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
            case USER:
                return new UserBoImpl();
            case GRID_PANE_ITEM:
                return new GridPaneItemBOImpl();
            default:
                return null;
        }
    }
}
