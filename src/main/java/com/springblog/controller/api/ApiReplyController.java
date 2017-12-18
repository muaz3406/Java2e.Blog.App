package com.springblog.controller.api;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springblog.controller.BaseController;
import com.springblog.model.Post;
import com.springblog.model.PostRepository;
import com.springblog.model.Reply;
import com.springblog.model.ReplyRepository;
import com.springblog.util.AjaxResult;

@Controller
@RequestMapping("api/post/{post}/reply")
@ResponseBody
public class ApiReplyController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ApiReplyController.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @RequestMapping(method = GET)
    public List<Reply> list(@PathVariable("post") Long post) {
        return postRepository.findOne(post).getReplyList();
    }

    @RequestMapping(method = POST)
    public AjaxResult add(@PathVariable("post") Long post, Reply reply) {
        reply.setPost(postRepository.getOne(post));
        replyRepository.saveAndFlush(reply);
        return AjaxResult.create();
    }

    @RequestMapping(value = "{id}", method = GET)
    public Reply get(@PathVariable("id") Long id) {
        return replyRepository.findOne(id);
    }

    @RequestMapping(value = "{id}", method = PUT)
    public Reply update(@PathVariable("id") Long id, Reply reply) {
        Reply fetch = replyRepository.findOne(id);
        fetch.update(reply);
        replyRepository.save(fetch);
        replyRepository.flush();
        return fetch;
    }

    @RequestMapping(value = "{id}", method = DELETE)
    public AjaxResult delete(@PathVariable("id") Long id) {
        replyRepository.delete(id);
        return AjaxResult.create();
    }
}
