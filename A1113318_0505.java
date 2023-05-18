import java.util.*;

import javax.swing.text.DefaultEditorKit.CutAction;
class selldumpling extends Thread{
    Eat n;
    int num;
		
    public selldumpling(Eat n, int num){
        this.n=n;
        this.num=num;
    }

    public void run(){
        n.eat();
    }
}

class Eat{

    public synchronized void eat(){
        String dumplingtypes[]={"pork","beef","vegitable"};
        int dumplingnums[]={5000,3000,1000};
        Random rand = new Random();
        int amount=rand.nextInt(41)+10;
        int type=rand.nextInt(dumplingtypes.length);
        while (true){
            if(dumplingnums[type]==0) {
                type=rand.nextInt(dumplingtypes.length);
            }
            else{
                break;
            }
        }
        System.out.println(Thread.currentThread().getName()+"buy"+amount+dumplingtypes[type]+"dumplings.");
        if(type==0){
            dumplingnums[0]=dumplingnums[0]-amount;
        }
        if(type==1){
            dumplingnums[1]=dumplingnums[1]-amount;
        }
        if(type==2){
            dumplingnums[2]=dumplingnums[2]-amount;
        }
        
        if(dumplingnums[0]+dumplingnums[1]+dumplingnums[2]==0){
            System.out.println("水餃賣完了");
            System.exit(0);
        }
        
    }
    public void startEat(int customer){
        for(int m=1;m<=customer;m++){
            selldumpling eater=new selldumpling(this,customer);
            eater.start(); 
            try{
                Thread.sleep(3000);
            }catch(InterruptedException n){

            }   
        }
        
        
    }
}

public class A1113318_0505 {
    public static void main(String[] args) throws Exception {
        Scanner input= new Scanner(System.in);
        System.out.println("Input the customer amount:");
        int customer=input.nextInt();
        Eat n=new Eat();
        n.startEat(customer);
    }
}
