//1

public void saveProduct(String productName, double price){
 productReposiroty.save(productName);
 priceRepository.save(price);
 }

 public void updatePurchase(String productName, double price){
    userRepository.updateUserPurchase(getCurrentUser(),
    productName, price);
 }
 public void createPurchase(String productName, double price){
    shopRepository.newPurchase(productName, price);
 }
 //2
 @PostMapping("/api/document")
 public User saveDocument(@RequestBody Document doc){
 doc.setCreationDate(new Date());
 doc.setCreator(sessionGetUserId());
 return documentRepository.save(doc);
 }
}
public long sessionGetUserId(){
return sessionRepository.getCurrentUser().getId();
} 
//3
public void updateProduct(long idProduct, String productName){
 productReposiroty.save(product);
 for(int i=0; i<products.size(); i++){
System.out.println(products.get(i));
 }
 productRepository.setName(productName);
 productReposiroty.find(product);
 List<Product> products = productRepository.findAll();
 Product product=null;
 return products;
}
//4
public void modifySummerTripPlan(TripPlan trip) {
    trip.setCreationDate(new Date());
    tripRepository.save(trip);

    eMailService.send(
        trip,
        trip.getMembers(),
        trip.getTickets(),
        trip.getItemsToTake(),
        trip.getMedicalInformation(),
        trip.getWeather()
    );
}
//5
public int saveGameResult(Player player, Result result)
serverConnection.renew();
return gameRepository.save(player, result);
} 

public int setPlayerWincount(Player player, Result result){
    
 if(player.getCountry()==”Poland” &&
 result.getScore()>1000){
player.setWinCount(player.getWinCount()+1);
}
}

public int sendResultMessage(Player player, Result result){
    player.sendMessage(result);
}
//6
public boolean checkUser(long userId, Token token) {
    return getVerifiedUser(userId, token) != null;
}

public User updateUser(long userId, Token token, String userName, String userTelNumber) {
    User user = getVerifiedUser(userId, token);
    if (user != null) {
        user.setTel(userTelNumber);
        return userRepository.save(user);
    }
    return null;
}

private User getVerifiedUser(long userId, Token token) {
    User user = userRepository.findById(userId);
    if (user != null && userRepository.verifyUser(user, token)) {
        return user;
    }
    return null;
}
//7 
List<Privilege> privileges =
getCountry(idCountry).getCompany(idCompany).getDepartment(idDe
partment).getEmploee(idDepartmentEmployee).gerPermissions();

public List<Privilege> getEmployeePrivileges(long countryId, long companyId, long departmentId, long employeeId) {
    
    Country country = getCountry(countryId);

    Company company = country.getCompany(companyId);

    Department department = company.getDepartment(departmentId);

    Employee employee = department.getEmployee(employeeId);

    return employee.getPermissions();
}
