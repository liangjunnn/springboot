package com.lj.controller.TestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lj.common.PageRequest;
import com.lj.common.Result;
import com.lj.controller.BaseController;
import com.lj.exception.UserException;
import com.lj.response.user.UserLimitResonse;
import com.lj.response.user.UserResponse;
import com.lj.service.userservice.UserService;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author : liangjun
 * @ClassName : TestController
 * @Description :
 * @Date : 2019/11/21 10:04
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    private final UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/queryUserInfo")
    public Result<UserResponse> queryUserInfo(Long id) {
        logger.info("查询用户信息：{}", id);
        UserResponse userInfo = new UserResponse();
        try {
            userInfo = userService.findUserInfo(id);
        } catch (UserException e) {
            logger.error(e.getMessage());
            return new Result<UserResponse>(e.getErrorMsgEnum().getCode(), e.getErrorMsgEnum().getMsg());
        }
        logger.info("查询用户信息返回:{}", JSON.toJSONString(userInfo));
        return new Result<UserResponse>(userInfo);
    }

    /**
     * 查询用户信息
     *
     * @param userLimitResonsePageRequest
     * @return
     */
    @PostMapping("/queryLimitUser")
    public Result<PageInfo<UserLimitResonse>> queryLimitUser(@RequestBody PageRequest<UserLimitResonse> userLimitResonsePageRequest) {
        PageInfo<UserLimitResonse> userAll = userService.findUserAll(userLimitResonsePageRequest);
        return new Result<PageInfo<UserLimitResonse>>(userAll);
    }

    @GetMapping("/getUser")
    public Result<Object> getUser() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserResponse userResponse1 = new UserResponse();
        userResponse1.setAddress("江苏省");
        userResponse1.setName("aaa");
        userResponse1.setDate(sdf.format(new Date()));

        UserResponse userResponse2 = new UserResponse();
        userResponse2.setAddress("四川省");
        userResponse2.setName("bb");
        userResponse2.setDate(sdf.format(new Date()));

        UserResponse userResponse3 = new UserResponse();
        userResponse3.setAddress("江苏省");
        userResponse3.setName("cc");
        userResponse3.setDate(sdf.format(new Date()));

        UserResponse userResponse4 = new UserResponse();
        userResponse4.setAddress("山东省");
        userResponse4.setName("dd");
        userResponse4.setDate(sdf.format(new Date()));

        List<UserResponse> userList = new ArrayList<UserResponse>();
        userList.add(userResponse1);
        userList.add(userResponse2);
        userList.add(userResponse3);
        userList.add(userResponse4);

//        Map<String, List<UserResponse>> users = userList.stream().collect(Collectors.groupingBy(UserResponse::getAddress));
        List<UserResponse> users = userList.stream().filter(user -> "江苏省".equals(user.getAddress())).collect(Collectors.toList());
        return new Result<Object>(users);
    }

    @GetMapping("/getPinYin")
    public Result<String> getPinYin(String src) {
        String pascalSpell = "";// 返回的拼音
        try {
            char[] cl_chars = src.trim().toCharArray();
            // 大写样式
            HanyuPinyinOutputFormat upperFormat = new HanyuPinyinOutputFormat();
            // 大写
            upperFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
            // 不带声调
            upperFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            // 小写样式
            HanyuPinyinOutputFormat lowerFormat = new HanyuPinyinOutputFormat();
            // 小写
            lowerFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            // 不带声调
            lowerFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            for (int i = 0; i < cl_chars.length; i++) {
                String str = String.valueOf(cl_chars[i]);
                // 如果字符是中文,则将中文转为汉语拼音,并取第一个字母大写，其他字母小写
                    if (str.matches("[\u4e00-\u9fa5]+")) {
                    pascalSpell += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], upperFormat)[0].substring(0, 1);
                    pascalSpell += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], lowerFormat)[0].substring(1);
                    // 如果字符是数字,取数字
                } else if (str.matches("[0-9]+")) {
                    pascalSpell += cl_chars[i];
                    // 如果字符是字母,取字母
                } else if (str.matches("[a-zA-Z]+")) {
                    pascalSpell += cl_chars[i];
                    // 否则不转换
                } else {
                    //如果是标点符号的话，带着
                    pascalSpell += cl_chars[i];
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            logger.error("字符不能转成汉语拼音");
            return new Result<String>("400", "字符不能转成汉语拼音");
        }
        logger.info("返回的汉语拼音：{}", pascalSpell);
        return new Result<String>(pascalSpell);
    }

}