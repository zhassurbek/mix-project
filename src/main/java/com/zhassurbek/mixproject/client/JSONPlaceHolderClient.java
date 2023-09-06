//package com.zhassurbek.mixproject.client;
//
//import com.zhassurbek.mixproject.model.Post;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
//@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
//public interface JSONPlaceHolderClient {
//
//    @RequestMapping(method = RequestMethod.GET, value = "/posts")
//    List<Post> getPosts();
//
//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
//}