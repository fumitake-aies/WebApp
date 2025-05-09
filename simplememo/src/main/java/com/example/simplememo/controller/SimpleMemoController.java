package com.example.simplememo.controller;

import com.example.simplememo.model.Memo;
import com.example.simplememo.service.MemoService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class SimpleMemoController {

    private final MemoService memoService;

    public SimpleMemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/insertmemo")
    public ModelAndView insertmemo() {
        ModelAndView mav = new ModelAndView("insertmemo");
        mav.addObject("memo", new Memo());
        return mav;
    }

    @PostMapping("/submitinsert")
    public ModelAndView submitinsert(@ModelAttribute("memo") @Valid Memo memo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("insertmemo");
            mav.addObject("memo", memo);
            return mav;
        }

        memo.setCreatedAt(LocalDateTime.now());
        memo.setUpdatedAt(LocalDateTime.now());
        memoService.insert(memo);
        return new ModelAndView("redirect:/memolist");
    }

    @GetMapping("/memolist")
    public ModelAndView memolist() {
        ModelAndView mav = new ModelAndView("memolist");
        mav.addObject("memolist", memoService.findAll());
        return mav;
    }

    /*@PostMapping("/deletememo")
    public ModelAndView deleteMemo(@RequestParam(value = "ids", defaultValue = "0") List<Integer> ids, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        if (ids != null && !ids.isEmpty()) {
            memoService.deleteMultiple(ids);
        }
        return new ModelAndView("redirect:/memolist");
    }
*/
    @PostMapping("/deletememo")
    public ModelAndView deletememo(@RequestParam(value = "ids",defaultValue = "0")List<Integer> ids){
        if (ids.size() == 0 || ids.isEmpty()) {
            return new ModelAndView("redirect:/memolist");
        }
        memoService.deleteMultiple(ids);
        return new ModelAndView("redirect:/memolist");
    }

}


/* 
@RestController
@RequestMapping("/api/memos")
public class SimpleMemoController {
    private final MemoService memoService;

    public SimpleMemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    // 全てのMemoレコードを取得するエンドポイント
    @GetMapping
    public List<Memo> getAllMemos() {
        return memoService.findAll();
    }

    // 新しいMemoレコードを作成するエンドポイント
    @PostMapping
    public int createMemo(@RequestBody String content) {
        // リクエストの内容から新しいMemoオブジェクトを作成し、Serviceに挿入を依頼
        Memo newMemo = new Memo(0, content, LocalDateTime.now(), LocalDateTime.now());
        memoService.insert(newMemo);
        // 作成したMemoのIDを返す
        return newMemo.getId();
    }

    // 指定されたIDのMemoレコードを更新するエンドポイント
    @PutMapping("/{id}")
    public void updateMemo(@PathVariable int id, @RequestBody String content) {
        // 指定されたIDのMemoレコードをServiceから取得し、内容を更新
        Memo memoToUpdate = memoService.findById(id);
        if (memoToUpdate != null) {
            memoToUpdate.setContent(content);
            memoToUpdate.setUpdatedAt(LocalDateTime.now());
            memoService.update(memoToUpdate);
        }
    }

    // 指定されたIDのMemoレコードを削除するエンドポイント
    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable int id) {
        // 指定されたIDのMemoレコードをServiceから削除
        memoService.delete(id);
    }
}

*/