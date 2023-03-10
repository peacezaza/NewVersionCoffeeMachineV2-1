public class CoffeeMachine {
    public CoffeeMachine() {
    }
    enum Coffee { ESPRESSO, LATTE, CAPPUCCINO }
    static final int ESPRESSO_WATER_ML_PER_CUP = 250;
    static final int ESPRESSO_MILK_ML_PER_CUP = 0;
    static final int ESPRESSO_BEANS_G_PER_CUP = 16;
    static final int ESPRESSO_PRICE = 4;
    static final int LATTE_WATER_ML_PER_CUP = 350;
    static final int LATTE_MILK_ML_PER_CUP = 75;
    static final int LATTE_BEANS_G_PER_CUP = 20;
    static final int LATTE_PRICE = 7;
    static final int CAPPUCCINO_WATER_ML_PER_CUP = 200;
    static final int CAPPUCCINO_MILK_ML_PER_CUP = 100;
    static final int CAPPUCCINO_BEANS_G_PER_CUP = 12;
    static final int CAPPUCCINO_PRICE = 6;
    static final int SIZE_S_PRICR = 0;
    static final int SIZE_M_PRICR = 5;
    static final int SIZE_L_PRICR = 10;
    private int machineMoney = 0;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int price;
    private int finalprice;
    private int presentSize;
    private int userMoney;
    private String typeCoffee;
    private String sizeCoffee;

    CoffeeMachine(int water, int milk, int beans, int cups) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
    }


    boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        return water >= waterNeeded &&
                milk >= milkNeeded &&
                beans >= beansNeeded &&
                cups >= 1;
    }
    public boolean EspressoNeed() {
        return canMakeCoffee(getESPRESSO_WATER_ML_PER_CUP(),
                getESPRESSO_MILK_ML_PER_CUP(),
                getESPRESSO_BEANS_G_PER_CUP());
    }

    public boolean LatteNeed() {
        return canMakeCoffee(getLATTE_WATER_ML_PER_CUP(),
                getLATTE_MILK_ML_PER_CUP(),
                getLATTE_BEANS_G_PER_CUP());
    }

    public boolean CappuccinoNeed() {
        return canMakeCoffee(getCAPPUCCINO_WATER_ML_PER_CUP(),
                getCAPPUCCINO_MILK_ML_PER_CUP(),
                getCAPPUCCINO_BEANS_G_PER_CUP());
    }
    public void makeEspresso() {
        useRawMaterials(getESPRESSO_WATER_ML_PER_CUP(),
                getESPRESSO_MILK_ML_PER_CUP(),
                getESPRESSO_BEANS_G_PER_CUP(),
                getFinalprice());
    }

    public void makeLatte() {
        useRawMaterials(getLATTE_WATER_ML_PER_CUP(),
                getLATTE_MILK_ML_PER_CUP(),
                getLATTE_BEANS_G_PER_CUP(),
                getFinalprice());
    }

    public void makeCappuccino() {
        useRawMaterials(getCAPPUCCINO_WATER_ML_PER_CUP(),
                getCAPPUCCINO_MILK_ML_PER_CUP(),
                getCAPPUCCINO_BEANS_G_PER_CUP(),
                getFinalprice());
    }

    public void useRawMaterials(int waterNeeded, int milkNeeded, int beansNeeded, int price){
        this.water -= waterNeeded;
        this.milk -= milkNeeded;
        this.beans -= beansNeeded;
        this.cups--;
        this.machineMoney += price;
    }
    public StringBuilder notEnough(int waterNeeded, int milkNeeded, int beansNeeded){
        StringBuilder sb = new StringBuilder();
        if (water < waterNeeded) {
            sb.append("water");
        } else if (milk < milkNeeded) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("milk");
        } else if (beans < beansNeeded) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("coffee beans");
        } else if (cups == 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("disposable cups");
        }
        return sb;
    }

    public int getESPRESSO_WATER_ML_PER_CUP(){
        return this.ESPRESSO_WATER_ML_PER_CUP;
    }

    public int getESPRESSO_MILK_ML_PER_CUP(){
        return this.ESPRESSO_MILK_ML_PER_CUP;
    }

    public int getESPRESSO_BEANS_G_PER_CUP(){
        return this.ESPRESSO_BEANS_G_PER_CUP;
    }

    public int getESPRESSO_PRICE(){
        return this.ESPRESSO_PRICE;
    }

    public int getLATTE_WATER_ML_PER_CUP(){
        return this.LATTE_WATER_ML_PER_CUP;
    }

    public int getLATTE_MILK_ML_PER_CUP(){
        return this.LATTE_MILK_ML_PER_CUP;
    }

    public int getLATTE_BEANS_G_PER_CUP(){
        return this.LATTE_BEANS_G_PER_CUP;
    }

    public int getLATTE_PRICE(){
        return this.LATTE_PRICE;
    }

    public int getCAPPUCCINO_WATER_ML_PER_CUP(){
        return this.CAPPUCCINO_WATER_ML_PER_CUP;
    }

    public int getCAPPUCCINO_MILK_ML_PER_CUP(){
        return this.CAPPUCCINO_MILK_ML_PER_CUP;
    }

    public int getCAPPUCCINO_BEANS_G_PER_CUP(){
        return this.CAPPUCCINO_BEANS_G_PER_CUP;
    }

    public int getCAPPUCCINO_PRICE(){
        return this.CAPPUCCINO_PRICE;
    }

    public int getWater(){
        return this.water;
    }

    public int getMilk(){
        return this.milk;
    }

    public int getBeans(){
        return this.beans;
    }

    public int getCups(){
        return this.cups;
    }

    public int getPrice(){
        return this.price;
    }

    public int getSizeS(){
        return SIZE_S_PRICR;
    }

    public int getSizeM(){
        return SIZE_M_PRICR;
    }

    public int getSizeL(){
        return SIZE_L_PRICR;
    }

    public int getFinalprice(){
        return this.finalprice;
    }

    public int getPresentSize(){
        return this.presentSize;
    }
    public int getUserMoney(){
        return this.userMoney;
    }

    public int getMachineMoney(){
        return  this.machineMoney;
    }
    public String getSizeCoffee(){
        return this.sizeCoffee;
    }

    public Coffee getCoffee(){
        for (Coffee type : Coffee.values()) {
            if(type.toString().equals(typeCoffee)){
                return type;
            }
        }
        return null;
    }
    public void setSizeCoffee(String size){
        this.sizeCoffee = size;
    }
    public void setUserMoney(int usermoney){
        this.userMoney = usermoney;
    }
    public void setFinalPrice(int finalPrice){
        this.finalprice = finalPrice;
    }
    public void setPresentSize(int present){
        this.presentSize = present;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setCoffee(String coffee){
       this.typeCoffee = coffee;
    }

    public void setWater(int water){
        this.water = water;
    }

    public void setMilk(int milk){
       this.milk = milk;
    }

    public void setBeans(int beans){
       this.beans = beans;
    }

    public void setCups(int cups){
       this.cups = cups;
    }

    public void doFillingAddedWater(int addedWater){
        water += addedWater;
    }

    public void doFillingAddedMilk(int addedMilk){
        milk += addedMilk;
    }

    public void doFillingAddedBeans(int addedBeans){
        beans += addedBeans;
    }

    public void doFillingAddedCups(int addedCups){
        cups += addedCups;
    }

}

