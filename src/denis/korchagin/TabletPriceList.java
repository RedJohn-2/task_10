package denis.korchagin;

public class TabletPriceList {
    private String modelName;
    private double amountOfMemory;
    private int ratingModel;
    private double price;

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setAmountOfMemory(double amountOfMemory) {
        this.amountOfMemory = amountOfMemory;
    }

    public void setRatingModel(int ratingModel) {
        this.ratingModel = ratingModel;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModelName() {
        return modelName;
    }

    public double getAmountOfMemory() {
        return amountOfMemory;
    }

    public int getRatingModel() {
        return ratingModel;
    }

    public double getPrice() {
        return price;
    }
}

