package org.Growingplant.PlantManagement;

public class PlantUpdater implements Runnable{
    private final PlantManager manager;
    private boolean running = true;

    public PlantUpdater(PlantManager manager) {
        this.manager = manager;
    }

    @Override
    public void run(){
        while(running){
            try{
                Thread.sleep(10000);
                manager.passDay();
                System.out.println("Plant state updated automatically");
            } catch (InterruptedException e) {
                running = false;
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop(){
        running = false;
    }

}
