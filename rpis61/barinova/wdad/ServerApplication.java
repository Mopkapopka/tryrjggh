package rpis61.barinova.wdad;


import rpis61.barinova.wdad.learn.rmi.Server;

public class ServerApplication {

    public static void main(String[] args) {
        var server = new Server();
        server.main();
    }
}
