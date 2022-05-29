package ss6_ke_thua.bai_tap;

    public class Loppoint3D extends Loppoint2D {
        public float z ;

        public Loppoint3D(float x, float y, float z) {
            super(x, y);
            this.z = z;
        }

        public Loppoint3D() {
        }

        public float getZ() {
            return z;
        }

        public void setZ(float z) {
            this.z = z;
        }
        public void setXYZ(float x , float y , float z){
            this.x = x;
            this.y = y ;
            this.z = z ;
        }
        public float[] getXYZ(){
            float[] arr = new float[3];
            return  arr= new float[]{this.x, this.y,this.z};
        }

        @Override
        public String toString() {
            return "LopPoint3d{" +
                    "z=" + z +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
