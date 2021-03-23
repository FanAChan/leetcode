package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class InvalidTransactions {


    public List<String> invalidTransactions(String[] transactions) {

        //name,time,count,city
        ArrayList<Transaction> arrayList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String transaction : transactions) {
            Transaction transactionVo = new Transaction(transaction);
            if (transactionVo.getCount()>1000) {
                list.add(transaction);
            }else{
                arrayList.add(transactionVo);
            }
        }
        arrayList.sort(Comparator.comparing(Transaction::getName).thenComparing(Transaction::getTime).thenComparing(Transaction::getCity));
        for (int i = 0; i < arrayList.size(); i++) {
            Transaction next = arrayList.get(i);
            for (int j = i + 1; j < arrayList.size(); j++) {
                Transaction next1 = arrayList.get(j);
                if(!next1.getName().equals(next.getName())){
                    break;
                }
                if(next1.getTime() - next.getTime() <= 60){
                    next.setValid(false);
                    next1.setValid(false);
                }
            }
        }
        for (Transaction transaction : arrayList) {
            if(!transaction.isValid()){
                list.add(transaction.toString());
            }
        }
        return list;
    }


    @Test
    public void test() throws Exception {
        InvalidTransactions invalidTransactions = new InvalidTransactions();
        for (String invalidTransaction : invalidTransactions.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"})) {
            System.out.println(invalidTransaction);
        }
    }

}
class Transaction{

    private String name;

    private int time;

    private int count;

    private String city;

    private boolean valid = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return  "\"" + name +
                "," + time +
                "," + count +
                "," + city +"\"";
    }

    public Transaction(String transaction) {
        String[] split = transaction.split(",");
        this.name = split[0];
        this.time = Integer.valueOf(split[1]);
        this.count = Integer.valueOf(split[2]);
        this.city = split[3];
    }

}

