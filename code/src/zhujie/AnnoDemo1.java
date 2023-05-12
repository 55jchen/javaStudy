package zhujie;

/**
 * @Author: qjc
 * @Date: 2023/5/12 12:00
 * @Description: TODO
 **/
@SuppressWarnings("all")// 压制警告
@MyAnno(show = "cc")
public class AnnoDemo1 {

    /**
     *
     * @param a
     * @param b
     * @return sum
     */
    public int add(int a,int b){
        return a+b;
    }


    @Deprecated // 过期方法
    public void show1(){}



    public void show2(){}



    public void myanno() {

    }
}
