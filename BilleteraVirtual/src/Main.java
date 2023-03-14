import exceptions.NegativeAmountException;
import exceptions.NotEnoughMoneyException;
import model.Wallet;

public class Main {
    public static void main(String[] args) {
        try{
            Wallet wallet = new Wallet("A0023421", 0);
            wallet.put(800);
            wallet.withDraw(1000);
        }catch(NegativeAmountException e){
            e.printStackTrace();
        }catch (NotEnoughMoneyException ex){
            ex.printStackTrace();
        }

    }
}