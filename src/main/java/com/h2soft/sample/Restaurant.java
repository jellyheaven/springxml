package com.h2soft.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//@Data 는 toStirng , setter
//@Component 는 <Bean class=“…”/>와 동일한 표현이다.
@Component
@Data
public class Restaurant {
	@Setter(onMethod_ =  @Autowired)
	private Chef chef;
}
