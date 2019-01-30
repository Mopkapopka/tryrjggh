package rpis61.barinova.wdad.data.managers;

import rpis61.barinova.wdad.data.managers.PreferencesManager;
import rpis61.barinova.wdad.utils.PreferencesManagerConstants;

import java.io.File;

public class test {
    public static void main(String[] args) throws Exception {
        String createregistry = "yes";
        String registryaddress = "localhost";
        String registryport = "1099";
        String policypath = "client.policy";
        String usecodebaseonly = "no";
        String classprovider = "http://www.yourhost.free.ru/cp/cp.jar";

        //File file = new File("C:\\Users\\Rina\\IdeaProjects\\starting-monkey-to-human-path\\src\\rpis61\\barinova\\wdad\\data\\managers\\file.xml");
        File fileOpen = new File("C:\\Users\\Rina\\IdeaProjects\\starting-monkey-to-human-path\\src\\rpis61\\barinova\\wdad\\resources\\configuration\\appconfig_test.xml");
        PreferencesManager pm ;
        pm = PreferencesManager.getInstance();
        pm.read("C:\\Users\\Rina\\IdeaProjects\\starting-monkey-to-human-path\\src\\rpis61\\barinova\\wdad\\resources\\configuration\\appconfig_test.xml");
        pm.setProperty(PreferencesManagerConstants.createregistry, "no" );
        System.out.println(pm.getProperty(PreferencesManagerConstants.createregistry));
    }
}
