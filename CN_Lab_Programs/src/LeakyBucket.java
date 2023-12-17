import java.util.*;
public class LeakyBucket {
public static void main(String[] args) throws InterruptedException {
int n,incoming,outgoing,store=0,bucketsize;
Scanner scan=new Scanner(System.in);
System.out.println("Enter bucket size, outgoing rate, number of inputs and incoming size");
bucketsize = scan.nextInt();
outgoing = scan.nextInt();
n=scan.nextInt();
incoming = scan.nextInt();
while(n!=0){
    System.out.println("Incoming size is " +incoming);
    if(incoming<=(bucketsize-store)){
        store+=incoming;
        System.out.println("Bucket buffer size is " +store+ " out of " +bucketsize);

    }
    else{
        System.out.println("PAcket loss: " +(incoming*(bucketsize-store)) );
        store+=incoming;
        System.out.println("Bucket buffer size is " +store+ " outgoing " +bucketsize);
    }
    store-=outgoing;
    System.out.println("After outgoing: " +store+ " packets left out of " +bucketsize+ " in buffer");
    n--;
    Thread.sleep(3000);
    scan.close();
}
    
}
}
