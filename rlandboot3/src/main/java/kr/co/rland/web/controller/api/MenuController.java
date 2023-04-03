package kr.co.rland.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;


@RestController("apiMenuController")   //이름을 명시해주면 충돌이 발생하지 않는다.
@RequestMapping("menus")
public class MenuController {
   
   
   @Autowired
   private MenuService service;

   @GetMapping
   public List<MenuView> getList(
         @RequestParam(name = "p", defaultValue = "1") int page,
         @RequestParam(name ="c" , required = false )  Integer categoryId,  //required를 사용하면 필수값으로 할지 안할지 알려줄수있다.
         @RequestParam(name ="q" , required = false )  String query){  
      //원래는 문서 url이 와야하는데..? restcontroller에게 요청하면 데이터를 받는다! url를 받는것이 아니다. 
                            //객체는 json형식으로 바꿔서 보내준다.
      List<MenuView> list = service.getViewList(page, categoryId, query);
          
      return list;
      //전에는 /menu/list라고url처럼 줬는데 지금은 왜 저런방식으로 주나?-> 데이터를 달라는 거기 때문에 
      //menu/list->이러한 페이지를 줘
      //restController는 ->data /menus->메뉴 목록을 받음
      //menus/3->메뉴에서 3번째를 달라 menu?id=3과 비슷
      //restcontoller는 메서드의 방식으로 사용하기때문에 url이 같다!
   }
   
   @GetMapping("{id}")
   public Menu get(
         @PathVariable("id") int id){  
      
      Menu menu = service.getById(id);
      
      return menu; 
   }
   
   @PutMapping
   public Menu  edit(
         @PathVariable("id")int id){   //쿼리스트링을 먼저 찾게 되기 때문에 쿼리스트링에 없으면 에러가 발생한다.
      //위에 putMapping과 연결하고 싶다면? @@PathVariable("id")
      Menu menu = new Menu();
      
      return menu; 
   }
   
   @DeleteMapping("{id}")
   public String delete(
         @PathVariable("id")
         int id){ 
      return "menu del";
   }
   
   @PostMapping
   public String insert(@RequestBody Menu menu){  
      
	   menu.setCategoryId(1);	   
	   service.add(menu);
	   System.out.println(menu.getName());
	   
      return "ok"; 
   }
   
   
}