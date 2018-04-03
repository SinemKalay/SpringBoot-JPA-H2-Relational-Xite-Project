package com.xite.demo;

import com.xite.demo.model.MusicVideo;
import com.xite.demo.service.IMusicVideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	IMusicVideoService musicVideoService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetMusicByID_Success(){
		MusicVideo musicVideo=musicVideoService.getMusicVideobyID(501218);
		Assert.notNull(musicVideo,"Get Music By ID test is succeed");
	}

	@Test
	public void testGetMusicByGenre_Success(){
		List<MusicVideo> musicVideoList=musicVideoService.getMusicVideobyGenre("Rock");
		Assert.notNull(musicVideoList,"Get Music By Genre test is succeed");
	}

}
