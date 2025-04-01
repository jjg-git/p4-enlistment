package group3.p4enlistment;

import group3.p4enlistment.gui.Web;

public class Main {
    public static void main(String[] args){
        Web web = Web.GetInstance();
        System.out.println("Mfw args: " + String.join(" ", args));
    }
}
