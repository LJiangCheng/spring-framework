package com.ljc.learning.aop.bean;

import com.ljc.learning.aop.bean.spec.Performance;
import org.springframework.stereotype.Component;

/**
 * 戏剧:《不眠之夜Sleep No More》
 */
@Component
public class SleepNoMore implements Performance {
	@Override
	public void perform() {
		System.out.println("表演戏剧《不眠之夜》");
	}
}
