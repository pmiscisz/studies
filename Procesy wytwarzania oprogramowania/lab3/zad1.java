
public class Storage {
     ArrayList<Item> items = new ArrayList<>();

    public final int STATUS_NEW = 0;
    public final int STATUS_SOLD = 1;

 

    public void addItemToStorage(Item item){
    items.add(item);
    }
    public void removeItemFromStorage(Item item){
 items.remove(item);
 }

 public void sellItemFromStorage(int storageIndex){
 Item item = items.get(storageIndex);
 item.setStus(STATUS_SOLD);
 }
}

public class Client {
    public void changeClientData(Client client, String name,
    String phone){
    client.setName(name);
    client.setPhone(phone);
 }
}

public class Producer {
    public Item produceItem(String name, int price){
 return new Item(name, price);
 }
}