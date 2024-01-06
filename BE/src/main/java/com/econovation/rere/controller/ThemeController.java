package com.econovation.rere.controller;

import com.econovation.rere.apiresponse.ApiResult;
import com.econovation.rere.apiresponse.ApiUtils;
import com.econovation.rere.domain.dto.request.ThemeCreateRequestDTO;
import com.econovation.rere.domain.dto.request.ThemeUpdateRequestDTO;
import com.econovation.rere.domain.dto.response.ThemeResponseDTO;
import com.econovation.rere.domain.entity.Theme;
import com.econovation.rere.service.CardService;
import com.econovation.rere.service.ThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class ThemeController {

    private final ThemeService themeService;
    private final CardService cardService;

    //    새로운 목차 생성
    @PostMapping("/cardbook/{cardbookId}/theme/new")
    public ApiResult<ThemeResponseDTO> createTheme(@RequestBody ThemeCreateRequestDTO themeCreateRequestDTO, @PathVariable("cardbookId") Integer cardbookId){
        //log.info("cardbookId" + cardbookId);
       return ApiUtils.success(themeService.register(themeCreateRequestDTO, cardbookId),"목차 생성에 성공하였습니다.");
    }

    //    해당 카드북의 모든 목차 가져오기
    @GetMapping("/cardbook/{cardbookId}/themes")
    public ApiResult<List<ThemeResponseDTO>> themepageThemes(@PathVariable Integer cardbookId){
        return ApiUtils.success(themeService.getAll(cardbookId),"목차를 조회에 성공하였습니다.");
    }

    //    목차,카드 수정하기
    @PutMapping("/cardbook/{cardbookId}/theme/{themeId}")
    public void modifyThemeAndCards(@RequestBody ThemeUpdateRequestDTO themeUpdateRequestDTO, @PathVariable Integer themeId){
        log.info(themeService.update(themeUpdateRequestDTO, themeId)+"");
    }
}