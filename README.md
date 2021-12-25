<h1>Java. Основы программирования на РТФ.</h1>
<h3>Вариант 4. Переводы</h3>
<h3>Работу выполнил: Козик Илья Павлович</h3>
<h3>Группа АТ-01</h3>
Последовательность выполнения работы:
<ol>
  <li>Создал проект</li>
  <li>Создал необходимые для выполнения java-классы:
    <ul>
      <li>ApplicationPanel для добавления панели с диаграммой на ApplicationFrame</li>
      <li>Database_our для работы с базой данных, с методами подключения к базе данных, создания таблицы, написания запросов в базу данных</li>
      <li>Offer для сохранения данных о переводах</li>
      <li>OffersOperations для создания списка переводов (экземпляров класса Offer)</li>
      <li>Task_1 для выполнения первой задачи</li>
      <li>Task_2 для выполнения второй задачи</li>
      <li>Task_3 для выполнения третьей задачи</li>
    </ul>
  </li>
  <li>Создал базу данных</li>
<ol>
<p>Программа работает вызывая метод main класса Main:</p>
<p><code>
public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, ParseException {

      Database_our.connect();
      Task_1.setMap();<br>
      ApplicationPanel panel = new ApplicationPanel();
      ApplicationFrame app= new ApplicationFrame("Task1");
      app.setMinimumSize(new Dimension(800, 800));
      app.add(panel.createDemoPanel(Task_1.getSum()));
      app.setVisible(true);

      Task_2.setMap();
      Task_2.doTask2();

      Task_3.doTask3();   }</code></p>
<p>Строка Database_our.connect() вызывает статический метод класса Database_our, который отвечает за подключение к базе данных.</p>
<p>Следующие 5 строк создают ApplicationFrame с размером 800x800 и с диаграммой сумм переводов за 2020 год.</p>
<img src="/SumOffers.jpg"></br>
<p>Строки Task_2.setMap() и Task2_2.doTask2() выводят в консоль средний размер перевода и количество переводов за каждый уникальный период</p>
<img src="/Task2.jpg"></br>
<p>Строка Task_3.doTask3() выводит в консоль максимальные и минимальные переводы за периоды с 2014 по 2016 г. и с 2016 по 2020 г.</p>
<img src="/Task3.jpg"></br>
