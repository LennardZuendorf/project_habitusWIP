package com.habitproject.service.habit;

class HabitServiceImplTest {

    /*
    //mock repository and RequestModel
    @Mock
    HabitRepository mockedHabitRepository;
    @Mock
    HabitRequestModel mockedHabitRequestModel;

    //class under test
    HabitService classUnderTest = new HabitServiceImpl(mockedHabitRepository);

    //values of existing test entry
    Long testHid1 = Long.getLong("999");
    String testTag1 = "buch lesen";
    HabitFrequency testFrequency1 = HabitFrequency.BIWEEKLY;
    int testQuantity1 = 1;
    String testUid1 = "999";

    //new test values
    String testTag2 = "test 2";
    HabitFrequency testFrequency2 = HabitFrequency.DAILY;
    int testQuantity2 = 5;
    String testUid2 = "999";



    @Test
    @DisplayName("should create proper HabitEntity")
    void postHabitTest() {
        when(mockedHabitRequestModel.getTag()).thenReturn(testTag2);
        when(mockedHabitRequestModel.getFrequency()).thenReturn(testFrequency2);
        when(mockedHabitRequestModel.getQuantity()).thenReturn(testQuantity2);
        when(mockedHabitRequestModel.getUid()).thenReturn(testUid2);

        HabitEntity expectedHabit = new HabitEntity(testTag2, testFrequency2, testQuantity2, testUid2);

        //expected
        var expected = new HabitStatusReturn(expectedHabit, HttpStatus.CREATED);

        //actual
        var actual = classUnderTest.postHabit(mockedHabitRequestModel);

        //assertion
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHabitTestTrue() {
        //expected
        var expected = ;

        //actual
        var actual = classUnderTest.getHabit();

        //
        Assertions.assertEquals(expected, actual);


    }

    @Test
    void getHabitTestFalse() {
        //ex

    }

    @Test
    void getAllHabitTest() {
    }

    @Test
    void putHabitTest() {
    }

    @Test
    void deleteHabitTest() {
    }

     */
}