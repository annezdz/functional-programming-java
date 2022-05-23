package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString() {
        return name + " : " + noOfStudents + " : " + reviewScore;
    }

}

public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> courses = List.of(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,20001),
                new Course("API","Microservices",97,20002),
                new Course("Microservices","Microservices",96,20003),
                new Course("Fullstack","Fullstack",91,20004),
                new Course("AWS","Cloud",90,20005),
                new Course("Azure","Framework",98,20006),
                new Course("Docker","Cloud",88,20007),
                new Course("Kubernetes","Cloud",99,20008)
        );

        //allMatch, noneMatch, anyMatch
        //Descobrir se todos os cursos tem pontuação maior que 95
        Predicate<Course> scoreCoursesGreaterThan95 = score -> score.getReviewScore() >= 95;
        Predicate<Course> scoreCoursesGreaterThan90 = score -> score.getReviewScore() >= 90;
        Predicate<Course> scoreCoursesGreaterThan85 = score -> score.getReviewScore() >= 85;

        //retorna falso

        System.out.println(courses.stream()
                .allMatch(scoreCoursesGreaterThan85));

        System.out.println(courses.stream()
                .noneMatch(scoreCoursesGreaterThan95));

        //AnyMatch verifica se algum dos cursos corresponde ao predicado

        System.out.println(courses.stream()
                .anyMatch(scoreCoursesGreaterThan95));

        //Using Comparator
        Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews =
                Comparator.comparing(Course::getNoOfStudents)
                        .thenComparing(Course::getReviewScore)
                        .reversed();


        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));
        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));
        //Usando 2 Comparators
        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList()));

        //Retornando apenas os 5 cursos mais vendidos
        System.out.println();
        System.out.println("Retornando apenas os 5 cursos mais vendidos");
        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
                .limit(5)
                .collect(Collectors.toList()));

        //Pulando os 3 melhores resultados
        System.out.println();
        System.out.println("Pulando os 3 melhores resultados");
        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .collect(Collectors.toList()));

        //Pulando 3 e limitando a 5 resultados
        System.out.println();
        System.out.println("Pulando 3 e limitando a 5 resultados");
        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList()));

        //Elemento que quebra o while interrompe o response
        System.out.println();
        System.out.println("Elemento que quebra o while interrompe o response");
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));

        //dropWhile continua verificando a condicao e quando for verdadeira, pula os elementos
        System.out.println();
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore()>=95)
                .collect(Collectors.toList()));
        //[Spring : 20000 : 98, Spring Boot : 20001 : 95, API : 20002 : 97,
        // Microservices : 20003 : 96, |||| -> retorna a partir desse ->
        // Fullstack : 20004 : 91, AWS : 20005 : 90,
        // Azure : 20006 : 98, Docker : 20007 : 88, Kubernetes : 20008 : 99]

        //Buscando o ultimo curso de acordo com o criterio comparingByNoOfStudentsAndNoOfReviews
        System.out.println("Buscando o curso máximo de acordo com o criterio comparingByNoOfStudentsAndNoOfReviews");
        System.out.println(courses.stream()
                .max(comparingByNoOfStudentsAndNoOfReviews));

        //Buscando o primeiro curso de acordo com o criterio comparingByNoOfStudentsAndNoOfReviews
        System.out.println("Buscando o curso máximo de acordo com o criterio comparingByNoOfStudentsAndNoOfReviews");
        System.out.println(courses.stream()
                .min(comparingByNoOfStudentsAndNoOfReviews));

        System.out.println();
        System.out.println(courses.stream().filter(scoreCoursesGreaterThan90)
                .min(comparingByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

        System.out.println();
        System.out.println("Retornar o primeiro elemento que atende determinado predicado");
        System.out.println(courses.stream()
                .filter(c -> c.getName()
                        .startsWith("A"))
                        .findFirst());

        System.out.println();
        System.out.println("Retornar qualquer valor que atende determinado predicado");
        System.out.println(courses.stream()
                .filter(c -> c.getName()
                        .startsWith("A"))
                .findAny());

        //Retorna numero médio de alunos para cursos que atendem determinada avaliação
        System.out.println("Retorna numero de alunos para cursos que atendem determinada avaliação");
        System.out.println(courses.stream()
                .filter(scoreCoursesGreaterThan95)
                .mapToInt(course -> course.getNoOfStudents()) //retorna o numero de estudantes como int
                .sum()); // e soma

        System.out.println("Retorna numero médio de alunos para cursos que atendem determinada avaliação");
        System.out.println(courses.stream()
                .filter(scoreCoursesGreaterThan95)
                .mapToInt(course -> course.getNoOfStudents()) //retorna o numero de estudantes como int
                .average()); // e a media

        System.out.println("Retorna numero de cursos que atendem determinada avaliação");
        System.out.println(courses.stream()
                .filter(scoreCoursesGreaterThan95)
                .mapToInt(course -> course.getNoOfStudents()) //retorna o numero de estudantes como int
                .count()); // e o contador
        System.out.println("Retorna o curso com o numero maximo de alunos que atendem determinada avaliação");
        System.out.println(courses.stream()
                .filter(scoreCoursesGreaterThan95)
                .mapToInt(course -> course.getNoOfStudents()) //retorna o numero de estudantes como int
                .max()); // e o max

        System.out.println("Retorna o curso com o numero maximo de alunos que atendem determinada avaliação");
        System.out.println(courses.stream()
                .filter(scoreCoursesGreaterThan95)
                .mapToInt(course -> course.getNoOfStudents()) //retorna o numero de estudantes como int
                .min()); // e o min
        System.out.println();
        System.out.println("Grouping By");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory())));

        //Contando o numero de cursos dentro de cada categoria
        System.out.println("Contando o numero de cursos dentro de cada categoria");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory(), Collectors.counting())));
        //{Cloud=3, Fullstack=1, Microservices=2, Framework=3}
        System.out.println();
        System.out.println("Retornando o curso de cada grupo com mais review scores");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory(),
                        Collectors.maxBy(Comparator.comparing(course -> course.getReviewScore())))));
        //{Cloud=Optional[Kubernetes : 20008 : 99], Fullstack=Optional[Fullstack : 20004 : 91],
        // Microservices=Optional[API : 20002 : 97], Framework=Optional[Spring : 20000 : 98]}

        //retornando apenas os nomes dos cursos separado por grupo
        System.out.println();
        System.out.println("retornando apenas os nomes dos cursos separado por grupo");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(course -> course.getCategory(),
                        Collectors.mapping(Course::getName,Collectors.toList()))));

        int cuttOffReview = 95;
        Predicate<Course> scoreCoursesGreaterThan951 = score -> score.getReviewScore() >= 95;
        Predicate<Course> scoreCoursesGreaterThan901 = score -> score.getReviewScore() >= 90;
        Predicate<Course> scoreCoursesGreaterThan851 = createPredicateWithCutOffReviewScore(cuttOffReview);
    }

    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cuttOffReview) {
        return score -> score.getReviewScore() >= cuttOffReview;
    }


}
