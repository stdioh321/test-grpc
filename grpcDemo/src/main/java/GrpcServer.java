import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.UserService;

import java.io.IOException;




public class GrpcServer {

    public static void main(String args[]) throws IOException, InterruptedException {

        System.out.println("starting GRPC Server");
        Server server = ServerBuilder.forPort(9090).addService(

                new UserService()).build();

        server.start();
        System.out.println("server started at " + server.getPort());
        server.awaitTermination();
    }
}
