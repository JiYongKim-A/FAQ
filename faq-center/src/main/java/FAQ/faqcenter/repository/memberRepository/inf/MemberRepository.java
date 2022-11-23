package FAQ.faqcenter.repository.memberRepository.inf;


import FAQ.faqcenter.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    // 회원 저장
    Member save(Member member);

    //로그인 id를 통해 회원 찾기
    Optional<Member> findByLoginId(String loginId);

    // id로 회원 찾기
    Member findById(Long id);

    // 모든 회원 찾기
    List<Member> findAll();

    // 메모리 리셋
    default void clearStore(){ }

}
