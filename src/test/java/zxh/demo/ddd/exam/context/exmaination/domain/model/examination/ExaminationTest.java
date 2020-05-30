package zxh.demo.ddd.exam.context.exmaination.domain.model.examination;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ExaminationTest {
    @Test
    void should_create_examination() {
        Examination examination = Examination.create(new ExaminationId(), "teacher-id");

        assertThat(examination, notNullValue());
    }

    @Test
    void should_fail_when_add_null_paper() {
        Examination examination = Examination.create(new ExaminationId(), "teacher-id");

        NullPointerException exception = assertThrows(NullPointerException.class, () -> examination.addPaper(null));

        assertThat(exception.getMessage(), is("Paper cannot null."));
    }

    @Test
    void should_fail_when_add_null_student_id() {
        Examination examination = Examination.create(new ExaminationId(), "teacher-id");

        NullPointerException exception = assertThrows(NullPointerException.class, () -> examination.addStudent(null));

        assertThat(exception.getMessage(), is("Student id cannot null."));
    }
}