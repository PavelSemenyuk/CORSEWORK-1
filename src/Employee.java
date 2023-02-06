

    public class Employee {
        // Поля
        private String name;
        private int department;
        private int salary;
        private static int counter;
        private int id;

        // Конструктор
        public Employee(String name, int department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            id = counter++;

            // Геттеры
        }

        public String getName() {
            return this.name;
        }

        public int getDepartment() {
            return this.department;
        }

        public int getSalary() {
            return this.salary;
        }

        public int getId() {
            return this.id;
        }

        // Сеттеры
        public void setDepartment(int department) {
            this.department = department;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Ф.И.О - " + this.name + ". Из отдела № " + this.department + ". Получает зарплату : " +
                    this.salary + " рублей. " + "ID: " + id;
        }

    }

