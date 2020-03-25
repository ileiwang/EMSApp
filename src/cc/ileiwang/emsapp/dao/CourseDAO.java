package cc.ileiwang.emsapp.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.InsertProvider;
//import org.apache.ibatis.annotations.Update;
//import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.dao.provider.*;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.*;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018��10��11�� ����10:42:06
 */
public interface CourseDAO {

	@SelectProvider(type = CourseDynaSqlProvider.class, method = "selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByParam(Map<String, Object> params);

	@SelectProvider(type = CourseDynaSqlProvider.class, method = "countCourse")
	int count(Map<String, Object> params);

	@SelectProvider(type = CourseDynaSqlProvider.class, method = "insertCourse")
	void save(Course course);

	@SelectProvider(type = CourseDynaSqlProvider.class, method = "updateCourse")
	void update(Course course);

	@Select("select * from " + COURSETABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectAll();
	
	//ĳרҵ����γ�
	@Select("select * from " + COURSETABLE +" where major_id = #{major_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByMajorId(int major_id);
	
	
	//ĳѧԺ����γ�
	@Select("SELECT course.* FROM course,major "
			+ "WHERE course.major_id = major.id AND major.college_id = #{college_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByCollegeId(int college_id);

	@Select("select * from " + COURSETABLE + " where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	Course selectById(int id);

	@Select("select * from " + COURSETABLE + " where num = #{num}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"), 
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	Course selectByNum(String num);

	//��ѯĳѧ����ѡ�α�
	@Select("select * from " + COURSETABLE
			+ " where id in (select course_id from stucou_item where student_id = #{student_id} )")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"),
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByStudentId(int student_id);

	
	@Select("select * from "+COURSETABLE+" where teacher_id = #{teacher_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"), 
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByTeacherId(int teacher_id);
	
	
	//ѡ��ĳרҵ�£�δ��ĳѧ��ѡ��Ŀγ�
	@Select("select * from " + COURSETABLE
			+ " where major_id=${major_id} and id not in(select course_id from stucou_item where student_id=${student_id})")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"),
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectByMajorAndStudentUnChoosen(@Param("major_id") int major_id,@Param("student_id")int student_id);
	
	//��IDɾ��
	@Delete("delete from " + COURSETABLE + " where id = #{id} ")
	void deleteById(int id);

	//���γ̺�ɾ��
	@Delete("delete from " + COURSETABLE + " where num = #{num} ")
	void deleteByNum(String num);

	//ͳ��ÿ�ſ�ѡ������(ʹ��Group By��ѯ)
	@Select("select course_id,course.num,course.name,count(student_id) as cnt from stucou_item,course where course.id=course_id group by course_id")
	List<Map<String,Object>> courseInfo();
	
	
	//ͳ��ĳ�ſ�ѡ�ε�ѧ���б�(ʹ��EXISTS��ѯ)
	@Select("select * from "+STUDENTTABLE+" where EXISTS (select * from stucou_item where student_id = student.id and course_id = #{course_id})")
	List<Student> courseStudentList(Integer course_id);
	
	
	//ͳ��ĳѧ��ѡ������(ʹ��Group By��ѯ)
	@Select("select student_id as studentid,student.num as studentnum,student.name as studentname,count(course_id) as coursecount from stucou_item,student where student.id = student_id group by student_id")
	List<Map<String,Object>>courseCountByStudent();
	
	//ѡ��3�ż����Ͽγ̵�ѧ��
	@Select("select student_id as studentid,student.num as studentnum,student.name as studentname from stucou_item,student where student.id = student_id group by student_id having count(*)>=3")
	List<Map<String,Object>> courseCountOverThree();
	
	//ͳ��ѡ������Ϊ30�˼����ϵĿγ�
	@Select("select course.* from stucou_item,course where course.id = course_id group by course_id having count(*)>=30")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"),
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectCourseByStudentCountMoreThanThirty();
	
	//ͳ��ѡ������Ϊ30�����µĿγ�
	@Select("select course.* from stucou_item,course where course.id = course_id group by course_id having count(*)<30")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "day", property = "day"), 
		@Result(column = "coursetime", property = "coursetime"),
		@Result(column = "start", property = "start"), 
		@Result(column = "last", property = "last"),
		@Result(column = "credit", property = "credit"),
		@Result(column = "place", property = "place"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
			one = @One(select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "teacher_id", property = "teacher", 
			one = @One(select = "cc.ileiwang.emsapp.dao.TeacherDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "id", property = "students", 
			many = @Many(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectByCourseId", 
			fetchType = FetchType.LAZY)) })
	List<Course> selectCourseByStudentCountLessThanThirty();
	
	
	//ѡ��
	@Insert("insert into stucou_item(student_id,course_id) values(${student_id},${course_id})")
	void chooseCourse(@Param("student_id")Integer student_id,@Param("course_id")Integer course_id);
	
	//�˿�
	@Insert("delete from stucou_item where student_id=${student_id} and course_id=${course_id}")
	void unchooseCourse(@Param("student_id")Integer student_id,@Param("course_id")Integer course_id);
}
