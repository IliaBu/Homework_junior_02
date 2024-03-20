package ru.gb_junior;

import ru.gb_junior.Asserter.Asserter;
import java.util.List;

/**
 * Доделать запускатель тестов:
 * 1. Создать аннотации BeforeEach, BeforeAll, AfterEach, AfterAll
 * 2. Доработать класс TestRunner так, что
 * 2.1 Перед всеми тестами запускаеются методы, над которыми стоит BeforeAll
 * 2.2 Перед каждым тестом запускаются методы, над которыми стоит BeforeEach
 * 2.3 Запускаются все тест-методы (это уже реализовано)
 * 2.4 После каждого теста запускаются методы, над которыми стоит AfterEach
 * 2.5 После всех тестов запускаются методы, над которыми стоит AfterAll
 * Другими словами, BeforeAll -> BeforeEach -> Test1 -> AfterEach -> BeforeEach -> Test2 -> AfterEach -> AfterAll
 *
 * 3.* Доработать аннотацию Test: добавить параметр int order,
 * по которому нужно отсортировать тест-методы (от меньшего к большему) и запустить в нужном порядке.
 * Значение order по умолчанию - 0
 * 4.** Создать класс Asserter для проверки результатов внутри теста с методами:
 * 4.1 assertEquals(int expected, int actual)
 * Идеи реализации: внутри Asserter'а кидать исключения, которые перехвываются в тесте.
 * Из TestRunner можно возвращать какой-то объект, описывающий результат тестирования.
 */

public class TestRunnerDemo {

  public static void main(String[] args) {
    List<String> results = TestRunner.run(TestRunnerDemo.class);
    System.out.println(Colors.YELLOW + "\n\r --------- Результаты тестов ---------" + Colors.RESET);
    results.forEach(System.out::println);
  }

  @BeforeAll
  public void beforeAll() {
    System.out.println("Команды перед всем тестом");
  }

  @BeforeEach
  public void beforeEach() {
    System.out.println("Команды перед каждым тестом");
  }

  @AfterEach
  public void afterEach() {
    System.out.println("Команды после каждого теста");
  }

  @AfterAll
  public void afterAll() {
    System.out.println("Команды после всего теста");
  }

  @Test(order = 1)
  public void test1() {
    System.out.println("test1 (3=3)");
    Asserter.assertEquals(3, 3);
  }

  @Test(order = 2)
  public void test2() {
    System.out.println("test2 (3=2)");
    Asserter.assertEquals(3, 2);
  }

  @Test
  public void test0() {
    System.out.println("test0 (1=2)");
    Asserter.assertEquals(1, 2);
  }

}
