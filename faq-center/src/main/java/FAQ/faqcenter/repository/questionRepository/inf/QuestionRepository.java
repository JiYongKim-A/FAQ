package FAQ.faqcenter.repository.questionRepository.inf;

import FAQ.faqcenter.domain.question.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    // question 저장
    Question save(Question question);

    //nickName을 통해 question 찾기
    Optional<Question> findQuestionByNickName(String nickName);

    // 관리번호 로 Question 찾기 //
    Optional<Question> findQuestionByNum(Long mangeNum);

    // 모든 Question 조회
    List<Question> findAll();


    //Question 삭제
    void removeQuestionByNum(Long mangeNum);

    //Question 수정
    Question update(Long mangeNum, Question questionParam);

    // 메모리 리셋
    default void clearStore(){ }


}
