package clone;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CloneTest {

    @Test
    public void arrayClone() throws Exception {
        //given
        int[] arr = {1, 2, 3, 4, 5};
        int[] cloneArr = arr.clone();
        //when
        cloneArr[0] = 10;
        arr[1] = 8;
        //then
        assertThat(cloneArr).containsExactly(10, 2, 3, 4, 5);
        assertThat(arr).containsExactly(1, 8, 3, 4, 5);
    }


}
