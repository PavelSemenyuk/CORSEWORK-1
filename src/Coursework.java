
public class Coursework {
    public static void main(String[] args) {

        /*1. Получить список всех сотрудников со всеми имеющимися по ним данными
        (вывести в консоль значения всех полей (toString)).*/

        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Иванов0 Иван0 Иванович0", 1, 52000);
        employee[1] = new Employee("Иванов1 Иван1 Иванович1", 1, 50000);
        employee[2] = new Employee("Иванов2 Иван2 Иванович2", 2, 70000);
        employee[3] = new Employee("Иванов3 Иван3 Иванович3", 2, 65000);
        employee[4] = new Employee("Иванов4 Иван4 Иванович4", 3, 48000);
        employee[5] = new Employee("Иванов5 Иван5 Иванович5", 3, 33000);
        employee[6] = new Employee("Иванов6 Иван6 Иванович6", 4, 45000);
        employee[7] = new Employee("Иванов7 Иван7 Иванович7", 4, 90000);
        employee[8] = new Employee("Иванов8 Иван8 Иванович8", 5, 35000);
        employee[9] = new Employee("Иванов9 Иван9 Иванович9", 5, 44000);

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                System.out.println(employee[i]);
            }
        }
        System.out.println();
        sumSalary(employee);
        System.out.println("СУММА ЗАТРАТ НА ЗП В МЕСЯЦ =  " + sumSalary(employee) + " рублей.");
        System.out.println();
        minSalary(employee);
        System.out.println("МИНИМАЛЬНАЯ ЗП У СОТРУДНИКА= " + minSalary(employee));
        System.out.println();
        maxSalary(employee);
        System.out.println("МАКСИМАЛЬНАЯ ЗП У СОТРУДНИКА = " + maxSalary(employee));
        System.out.println();
        averageSalary(employee);
        System.out.println("СРЕДНЯЯ ЗП = " + averageSalary(employee) + " рублей.");
        System.out.println();
        totalEmployee(employee);
        System.out.println();
        getPercentSalary(employee, 12);
        System.out.println();
        System.out.println(printEmployeeWithMinimalSalary(employee, 5));
        System.out.println();
        System.out.println(printEmployeeWithMaximalSalary(employee, 3));
        System.out.println();
        System.out.println("Сумма затрат отдела = " + sumSalaryDepartment(employee, 4) + " рублей.");
        System.out.println();
        System.out.println("Средняя сумма затрат отдела в месяц = " + averageSalaryDepartment(employee, 1)
                + " рублей.");
        System.out.println();
        indexSalaryDepartment(employee,3, 10);
        System.out.println();
        minSalaryAllEmployee(employee, 50000);
        System.out.println();
        maxSalaryAllEmployee(employee,60000);

    }

    //2. Посчитать сумму затрат на зарплаты в месяц.
    public static int sumSalary(Employee[] employee) {
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                sum = sum + employee[i].getSalary();
            }
        }
        return sum;
    }

    // 3. Найти сотрудника с минимальной зарплатой.
    public static Employee minSalary(Employee[] employee) {
        int minSum = sumSalary(employee);
        int minSumId = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < minSum) {
                minSum = employee[i].getSalary();
                minSumId = i;
            }
        }
        return employee[minSumId];
    }

    // 4. Найти сотрудника с максимальной зарплатой.
    public static Employee maxSalary(Employee[] employee) {
        int maxSum = 0;
        int maxSumId = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > maxSum) {
                maxSum = employee[i].getSalary();
                maxSumId = i;
            }
        }
        return employee[maxSumId];
    }

    // 5. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    public static int averageSalary(Employee[] employee) {
        int averageSum = 0;
        int sumDepart = 0;
        int average = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                averageSum = averageSum + employee[i].getSalary();
                sumDepart = sumDepart + 1;
                average = averageSum / sumDepart;
            }
        }
        return average;
    }

    // 6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
    public static void totalEmployee(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    //ПОВЫШЕННАЯ СЛОЖНОСТЬ
    // Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public static void getPercentSalary(Employee[] employee, int percent) {

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                employee[i].setSalary(employee[i].getSalary() + (employee[i].getSalary() / 100 * percent));
                System.out.println(employee[i]);
            }
        }
    }

/*Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
1. Сотрудника с минимальной зарплатой.
2. Сотрудника с максимальной зарплатой.
3. Сумму затрат на зарплату по отделу.
4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    */

    public static Employee printEmployeeWithMinimalSalary(Employee[] employee, int numberDepartment) {
        int minSalary = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == numberDepartment) {
                if (employee[i].getSalary() < minSalary) {
                    minSalary = employee[i].getSalary();
                    index = i;
                }
            }
        }
        return employee[index];
    }

    public static Employee printEmployeeWithMaximalSalary(Employee[] employee, int numberDepartment) {
        int maxSalary = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == numberDepartment) {
                if (employee[i].getSalary() > maxSalary) {
                    maxSalary = employee[i].getSalary();
                    index = i;
                }
            }
        }
        return employee[index];
    }

    public static int sumSalaryDepartment(Employee[] employee, int numberDepartment) {
        int maxSalDep = 0;

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == numberDepartment) {
                maxSalDep = maxSalDep + employee[i].getSalary();
            }
        }
        return maxSalDep;
    }

    public static int averageSalaryDepartment(Employee[] employee, int numberDepartment) {
        int salDep = 0;
        int averageSalDep = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == numberDepartment) {
                salDep = (salDep + employee[i].getSalary());
                averageSalDep = salDep / 2;
            }
        }
        return averageSalDep;
    }

    public static void indexSalaryDepartment(Employee[] employee, int numberDepartment, int percent) {

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == numberDepartment) {
                employee[i].setSalary(employee[i].getSalary() + (employee[i].getSalary() / 100 * percent));
                System.out.println(employee[i]);
            }
        }
    }
     /*
    3. Получить в качестве параметра число и найти:
        1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
     */

    public static void minSalaryAllEmployee(Employee[] employee, int number1) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() <= number1) {

                System.out.println("ID " + employee[i].getId()+", ФИО "+employee[i].getName()+
                        ", ЗП "+employee[i].getSalary());
            }
        }
    }
    public static void maxSalaryAllEmployee(Employee[] employee, int number2) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary()>=number2) {

                System.out.println("ID " + employee[i].getId()+", ФИО "+employee[i].getName()+
                        ", ЗП "+employee[i].getSalary());
            }
        }
    }
}

