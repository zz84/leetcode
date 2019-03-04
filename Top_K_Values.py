def quicksort_partition(lst, pivot_idx):
    lst[0], lst[pivot_idx] = lst[pivot_idx], lst[0]
    pivot_val = lst[0]
    i, j = 1, 1
    while j < len(lst):
        if lst[j] <= pivot_val:
            lst[j], lst[i] = lst[i], lst[j]
            i += 1
        j += 1

    lst[0], lst[i-1] = lst[i-1], lst[0]
    return lst, i-1

def get_Kth(lst, k):
    if lst == [] or k >= len(lst) or k < 0:
        raise Exception('empty list or invalid k')
    if len(lst) == 1:
        return lst[0]
    lst, new_k = quicksort_partition(lst, k)
    if new_k == k:
        return lst[new_k]
    elif new_k < k:
        return get_Kth(lst[new_k:], k - new_k)
    else:
        return get_Kth(lst[:new_k], k)

def top_k(lst, k):
    if k == 0:
        return []
    kth = get_Kth(lst, k-1)
    return list(filter(lambda x : x < kth, lst)) + [kth]
