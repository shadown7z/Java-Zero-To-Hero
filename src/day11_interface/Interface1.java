package day11_interface;

public class Interface1 {
    public static void main(String[] args) {
        InterImpl ii = new InterImpl();
        ii.method();
        ii.show();
    }
    interface Inter{
        public abstract void show();
        public abstract void method();
    }

   static class InterImpl implements Inter{

        @Override
        public void show() {
            System.out.println("重写后的show方法");
        }

        @Override
        public void method() {
            System.out.println("重写后的method方法");
        }
    }



}
