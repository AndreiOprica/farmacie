import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner options = new Scanner(System.in);
        int ok = 1;

        while (ok == 1) {

            System.out.println("1 - Afisarea tuturor farmaciilor din Timisoara");
            System.out.println("2 - Afisarea tuturor farmaciilor cu Nurofen pe stoc");
            System.out.println("3 - Afisarea cantitatii totale de Algocalmin din Timisoara");
            System.out.println("Orice tasta pentru a iesii.");

            int opt = options.nextInt();

            if (opt < 1 || opt > 5) {
                ok = 0;
            }
            else {
                if (opt == 1) {
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-farmacie", "root", "*******");

                        Statement statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery("select * from farmacii");

                        while (resultSet.next()) {
                            String nume = resultSet.getString("nume");
                            String oras = resultSet.getString("oras");
                            if (Objects.equals(oras, "Timisoara")) {
                                System.out.println(nume);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (opt == 2) {
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-farmacie", "root", "L4bw5qrgong99");

                        Statement statement = connection.createStatement();


                        ResultSet resultSet = statement.executeQuery("select * from farmacii left join stoc on farmacii.cod=stoc.cod");

                        while (resultSet.next()) {
                            String nume = resultSet.getString("nume");
                            String medicament = resultSet.getString("medicament");
                            if (Objects.equals(medicament, "Nurofen")){
                                System.out.println(nume);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (opt == 3) {
                    int total = 0;
                    try {

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-farmacie", "root", "L4bw5qrgong99");

                        Statement statement = connection.createStatement();


                        ResultSet resultSet = statement.executeQuery("select * from farmacii left join stoc on farmacii.cod=stoc.cod");

                        while (resultSet.next()) {
                            String oras = resultSet.getString("oras");
                            String medicament = resultSet.getString("medicament");
                            int stoc = resultSet.getInt("stoc");
                            if (Objects.equals(medicament, "Ashwagandha") && Objects.equals(oras, "Timisoara")){
                                total += stoc;
                            }
                        }
                        System.out.println(total);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }


            }




            }

        }

    }

