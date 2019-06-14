import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class junitExample {

    @Test
    public void test1(){
        String expected="lalala";
        String actual="bububu";

        assertEquals(expected,actual);
    }
    @Test
    public void test2(){
        String expected="lalala";
        String actual="bububu";
        assertEquals("song lyrics",expected,actual);
    }
    class User{
        public String username;
        public  User(String username){
            this.username=username;
        }
        @Override
        public boolean equals(Object o){
            if(!(o instanceof User))
                return false;
            return  ((User)o).username==this.username;
        }
    }

}
