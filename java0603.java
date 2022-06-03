public class InternetGateWay {
}
public class NATGateWay {
    public String Id;
    public String subnet;
}
public class RouteTable {
    public String Id;
    public String Gateway;
    public String SubnetList;


    public void addSubnet(){

    }

    public set

}

public class Subnet {
    public String Id;
    public String Region;
    public String Ip;
    public String RouteTable;
}

public void transfer(String msg){

}




public class Main {
    public static void main(String[] args) {
        Subnet subnet_a = new Subnet(1,"172.31.0.0/20","ap-northeast-2a");
        Subnet subnet_b = new Subnet(2,"172.31.16.0/20","ap-northeast-2b");
        Subnet subnet_c = new Subnet(3,"172.31.32.0/20","ap-northeast-2c");
        Subnet subnet_d = new Subnet(4,"172.31.48.0/20","ap-northeast-2d");

        GateWay internetGateWay = new InternetGateWay();
        //GateWay natGateWay = new NatGateWay(subnet_d); // infinity loop error
        GateWay natGateWay = new NatGateWay(subnet_a); // success
        RouteTable publicRouteTable = new RouteTable();
        RouteTable privateRouteTable = new RouteTable();

        publicRouteTable.setGateWay(internetGateWay);
        publicRouteTable.addSubnet(subnet_a);
        publicRouteTable.addSubnet(subnet_b);
        publicRouteTable.addSubnet(subnet_c);


        privateRouteTable.setGateWay(natGateWay);
        privateRouteTable.addSubnet(subnet_d);

        subnet_a.transfer("a send message!");
        subnet_d.transfer("d send message!");
    }
}
