package dev.racingcar.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dev.racingcar.demo.controller.RacingCarController;
import dev.racingcar.demo.exception.GlobalExceptionHandler;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final RacingCarController racingCarController;
	private final ApplicationContext context;
	private final GlobalExceptionHandler globalExceptionHandler;

	public DemoApplication(RacingCarController racingCarController, ApplicationContext context, GlobalExceptionHandler globalExceptionHandler) {
		this.racingCarController = racingCarController;
		this.context = context;
		this.globalExceptionHandler = globalExceptionHandler;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			racingCarController.racingCarStart(); // 실행 시 바로 실행
		}
		catch (Exception e) {
			globalExceptionHandler.handle(e);
		}
		//프로그램 종료
		int exitCode = SpringApplication.exit(context, () -> 0);
		System.exit(exitCode);
	}
}
