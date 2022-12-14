package com.example.task2.controller;

import com.example.task2.dto.TransactionDTO;
import com.example.task2.dto.UserRegisterForm;
import com.example.task2.entity.Kassa;
import com.example.task2.entity.User;
import com.example.task2.service.CurrencyService;
import com.example.task2.service.KassaService;
import com.example.task2.service.TransactionService;
import com.example.task2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TransactionController {
    private final KassaService kassaService;
    private final CurrencyService currercyService;
    private final TransactionService transactionService;
    private final UserService userService;

    @GetMapping("/")
    public String getTopProducts(Model model){
        model.addAttribute("select_kassa",kassaService.getListOfKassa());
        model.addAttribute("select_currency",currercyService.getListOfCurrency());
        return "index";

    }

    @PostMapping("/")
    public String registerPage(TransactionDTO trDTO) {

       transactionService.saveTransaction(trDTO);
        return "successfully_created";
    }

    @GetMapping("/uniq")
    public String getUniqCode() {
        return "uniqCode";
    }

    @PostMapping("/uniq")
    public String checkUniqCode(Model model, @RequestParam("uniqCode") String uniqCode,RedirectAttributes attributes) {

        attributes.addFlashAttribute("transfer",transactionService.checkCode(uniqCode));
        return "redirect:/get_money";
    }

    @GetMapping("/get_money")
    public String getMoney() {

        return "get_money";
    }

    @PostMapping("/get_money")
    public String getMoneyPost(@RequestParam("transferId") Long transferId,RedirectAttributes attributes) {
        transactionService.getMoney(transferId);

        attributes.addFlashAttribute("select_kassa",kassaService.getListOfKassa());
        attributes.addFlashAttribute("select_currency",currercyService.getListOfCurrency());

        return "redirect:/";
    }
    @GetMapping("/transfers")
    public String getAllTransfers(Model model, Pageable pageable, Authentication auth) {
        model.addAttribute("transfer",transactionService.getAllTransactions(pageable).getContent());
        User user = userService.getUserEmail(auth.getName());
        model.addAttribute("kassa", user.getKassa());
        return "transfers";
    }

    @PostMapping("/transfers")
    public String getAllTransfersSorted(@RequestParam("filter") String filter, Model model, Pageable pageable, Authentication auth) {
        model.addAttribute("transfer",transactionService.getAllTransactionsSort(filter));
        User user = userService.getUserEmail(auth.getName());
        model.addAttribute("kassa", user.getKassa());
        return "transfers";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPagePOST(@RequestParam("username") String username) {
        return "login";
    }

    @GetMapping("/register")
    public String pageRegisterCustomer() {
        return "/register";
    }

    @PostMapping("/register")
    public String registerPage(UserRegisterForm userRequestDto, RedirectAttributes attributes) {

        userService.register(userRequestDto);

        return "redirect:/login";
    }

    @GetMapping("/balance")
    public String getBalance(Model model) {
        model.addAttribute("select_kassa",kassaService.getListOfKassa());
        return "/balance";
    }

    @PostMapping("/balance")
    public String getBalancePOST(Model model, @RequestParam("fromKassa") Kassa fromKassa) {
        model.addAttribute("select_kassa",kassaService.getListOfKassa());
        model.addAttribute("balance", transactionService.showBalance(fromKassa));

        return "/balance";
    }
}
