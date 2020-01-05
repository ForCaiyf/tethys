package com.caiyf.tethys.message.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * zhenzi result
 *
 * @author caiyf
 * @date 2020-01-05
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZhenziResultModel {

    private Integer code;
    private String data;

    public static ZhenziResultModel returnEmptyResult() {
        return ZhenziResultModel.builder().code(-1).data("返回值为空").build();
    }

}
