/*
 * Адаптер (англ. Adapter) — структурный шаблон проектирования, предназначенный
 * для организации использования функций объекта, недоступного для модификации, 
 * через специально созданный интерфейс. Другими словами — это структурный 
 * паттерн проектирования, который позволяет объектам с несовместимыми 
 * интерфейсами работать вместе.
 */
package adapter;

/**
 *
 * @author AKravchuk
 */
public class AdapterApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1-й сполос через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        // 2-й способ через композицию
        //VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g2.drawLine();
        g2.drawSquare();
    }

}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Draw line");
    }

    void drawRasterSquare() {
        System.out.println("Draw square");
    }
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
    
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    //RasterGraphics raster = new RasterGraphics();
    RasterGraphics raster = null;
    
    public VectorAdapterFromRaster2(RasterGraphics raster) {
        this.raster = raster;
    }
    
    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
    
}