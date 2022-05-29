package ss6_ke_thua.bai_tap;
import java.lang.reflect.Array;
public class Loppoint2D {


        public float x,y;

        public Loppoint2D() {
        }

        public Loppoint2D(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
        public void setXY(float x , float y){
            this.x =  x;
            this.y = y ;
        }
        public float[] getXY(){
            float[] arr = new float[2];
            return  arr= new float[]{this.x, this.y};
        }

        @Override
        public String toString() {
            return "Loppoint2D{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
