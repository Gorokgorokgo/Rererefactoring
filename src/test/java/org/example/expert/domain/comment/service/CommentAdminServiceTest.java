package org.example.expert.domain.comment.service;

import org.example.expert.domain.comment.entity.Comment;
import org.example.expert.domain.comment.repository.CommentRepository;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommentAdminServiceTest {

  @Mock
  private CommentRepository commentRepository;

  @BeforeEach
  void setUp() {
    Long commentId = 1L;
    User user = new User();
    Todo todo = new Todo();
    Comment comment = new Comment("oh", user, todo);
  }

  @Test
  void 일정_삭제() {
    //given
    given(commentRepository.findByTodoIdWithUser(todo.getId()).willReturn(true));


    //when

    //then


  }

}

