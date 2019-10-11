/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @date 2019-03-30 14:13
 */
enum FinalOrAbstractEnumDemo implements MarkInterface{

//    ONE(),TWO();
    ONE(){
        @Override
        public void getInstance() {

        }
    },TWO {
        @Override
        public void getInstance() {

        }
    };

    /**
     *
     */
    public abstract void getInstance();


}


// Custom styles.


