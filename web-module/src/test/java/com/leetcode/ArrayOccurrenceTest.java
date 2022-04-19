package com.leetcode;

public class ArrayOccurrenceTest {

    public void test_Occurrence_With_Duplicate(){
        ArrayOccurrence arrayOccurrence = new ArrayOccurrence();
        int result = arrayOccurrence.occurrence(new int[]{1, 3, 3, 1, 4});
        assert result == 3;
    }

    //Expect an exception
    public void test_Occurrence_Without_Duplicate(){
        ArrayOccurrence arrayOccurrence = new ArrayOccurrence();
        int result = arrayOccurrence.occurrence(new int[]{1, 4, 5, 7, 8});
    }

    //Expect an exception
    public void test_Occurrence_empty_array(){
        ArrayOccurrence arrayOccurrence = new ArrayOccurrence();
        int result = arrayOccurrence.occurrence(new int[]{1, 4, 5, 7, 8});
    }
    //Expect an exception
    public void test_Occurrence_null_array(){
        ArrayOccurrence arrayOccurrence = new ArrayOccurrence();
        int result = arrayOccurrence.occurrence(null);
    }

    //Expect an exception
    public void test_Occurrence_invalid_array_element(){
        ArrayOccurrence arrayOccurrence = new ArrayOccurrence();
        int result = arrayOccurrence.occurrence(null);
    }
}
