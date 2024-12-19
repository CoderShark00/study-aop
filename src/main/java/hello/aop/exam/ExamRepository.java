package hello.aop.exam;


import hello.aop.exam.annotation.Trace;
import hello.aop.exam.annotation.Retry;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {

    private static int seq = 0;

    /**
     * 5번에 1번 실패한느 요청
     *
     */
    @Retry
    @Trace
    public String save(String itemId){
        seq++;
        if (seq % 5 == 0){
            throw new IllegalStateException("예외발생");
        }
        return "ok";
    }
}
