package com.hasan.smartcontactmanager.repositories;

import com.hasan.smartcontactmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    
    
    @Query("select new map(ql1.id.counsellingid as counsellingid, ql1.id.applicationid "
			+ " as applicationid, ql1.id.subjectname as subjectname, ql1.marksobtained as marksobtained) from QLYExamMarks ql1, QLYExamMarks ql2 where "
			+ "(:subject1 is null or ql1.id.subjectname= :subject1 and"
			+ " ql1.marksobtained< :subject1marks) and (:subject2 is null or ql2.id.subjectname= :subject2  and ql2.marksobtained<= :subject2marks)and "
			+ " ql1.id.applicationid=ql2.id.applicationid and ql1.id.subjectname=ql2.id.subjectname ")
	List<Map> getStudents( @Param("subject1") String subject1, @Param("subject2") String subject2, @Param("subject1marks") String subject1marks, @Param("subject2marks") String subject2marks);
}

    
    
}
